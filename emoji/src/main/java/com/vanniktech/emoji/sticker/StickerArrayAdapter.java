package com.vanniktech.emoji.sticker;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.airbnb.lottie.LottieListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.vanniktech.emoji.EmojiImageView;
import com.vanniktech.emoji.R;
import com.vanniktech.emoji.sticker.struct.StructItemSticker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;


final class StickerArrayAdapter extends ArrayAdapter<StructItemSticker> {
    private List<StructItemSticker> mSticker;
    private OnStickerListener onStickerListener;
    private OnDownloadStickerListener onDownloadStickerListener;

    StickerArrayAdapter(@NonNull final Context context, @NonNull List<StructItemSticker> mSticker, OnStickerListener onStickerListener, OnDownloadStickerListener onDownloadStickerListener) {
        super(context, 0, mSticker);
        this.mSticker = mSticker;
        this.onStickerListener = onStickerListener;
        this.onDownloadStickerListener = onDownloadStickerListener;
    }

    @NonNull
    @Override
    public View getView(final int position, final View convertView, @NonNull final ViewGroup parent) {

        final Context context = getContext();

        if (mSticker.get(position).getUri().endsWith(".json")) {

            final LottieStickerView lottieAnimationView = (LottieStickerView) LayoutInflater.from(context).inflate(R.layout.emoji_lottie, parent, false);

            lottieAnimationView.setFailureListener(new LottieListener<Throwable>() {
                @Override
                public void onResult(Throwable result) {
                    Log.e(getClass().getName(), "onResult: ", result);
                }
            });

            File file = new File(mSticker.get(position).getUri());
            if (file.exists() && file.canRead()) {
                try {
                    lottieAnimationView.setAnimation(new FileInputStream(mSticker.get(position).getUri()), mSticker.get(position).getToken());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                final StructItemSticker sticker = mSticker.get(position);
                onDownloadStickerListener.downloadLottieStickerItem(sticker, new OnLottieStickerItemDownloaded() {
                    @Override
                    public void onStickerItemDownload(String token, String path) {
                        if (token.equals(mSticker.get(position).getToken()) && path.endsWith(".json")) {
                            try {
                                lottieAnimationView.setAnimation(new FileInputStream(path), token);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }

            lottieAnimationView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    StickerDatabase stickerDatabase = StickerView.getStickerDatabase(context);
                    stickerDatabase.insertOrUpdateRecentlySticker(mSticker.get(position).getId(), mSticker.get(position).getRefId(), mSticker.get(position).getName(), mSticker.get(position).getToken(), mSticker.get(position).getUri(), mSticker.get(position).getSort(), mSticker.get(position).getGroupId(), System.currentTimeMillis());
                    if (onStickerListener != null)
                        onStickerListener.onItemSticker(mSticker.get(position));
                }
            });

            return lottieAnimationView;
        } else {
            EmojiImageView image = (EmojiImageView) LayoutInflater.from(context).inflate(R.layout.emoji_item, parent, false);

            image.setImageBitmap(null);
            String path = mSticker.get(position).getUri();

            if (new File(path).exists()) {
                Glide.with(context).load(path)
                        .apply(new RequestOptions().override(160, 160))
                        .transition(DrawableTransitionOptions.withCrossFade(200))
                        .into(image);
            } else {
                final EmojiImageView finalImage = image;
                final StructItemSticker sticker = mSticker.get(position);
                onDownloadStickerListener.downloadStickerItem(sticker, new OnStickerItemDownloaded() {
                    @Override
                    public void onStickerItemDownload(String token, String path) {
                        if (token.equals(sticker.getToken())) {
                            Glide.with(context).load(path)
                                    .apply(new RequestOptions().override(160, 160))
                                    .transition(DrawableTransitionOptions.withCrossFade(200))
                                    .into(finalImage);
                        }
                    }
                });
            }


            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    StickerDatabase stickerDatabase = StickerView.getStickerDatabase(context);
                    stickerDatabase.insertOrUpdateRecentlySticker(mSticker.get(position).getId(), mSticker.get(position).getRefId(), mSticker.get(position).getName(), mSticker.get(position).getToken(), mSticker.get(position).getUri(), mSticker.get(position).getSort(), mSticker.get(position).getGroupId(), System.currentTimeMillis());
                    if (onStickerListener != null)
                        onStickerListener.onItemSticker(mSticker.get(position));
                }
            });

            return image;
        }
    }

}
