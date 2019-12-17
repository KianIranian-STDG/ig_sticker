package com.vanniktech.emoji.sticker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.vanniktech.emoji.R;
import com.vanniktech.emoji.sticker.struct.StructGroupSticker;
import com.vanniktech.emoji.sticker.struct.StructItemSticker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


@SuppressLint("ViewConstructor")
public final class StickerView extends LinearLayout implements ViewPager.OnPageChangeListener {

    private RecyclerView rcvTab;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private OnPageChangeMainViewPager onChangeViewPager;
    private final StickerPagerAdapter stickerPagerAdapter;
    //    public static OnNotifyList onNotifyList;
    private int stickerTabLastSelectedIndex = -1;
    private static StickerDatabase stickerDatabase;
    private OnOpenPageStickerListener myOnOpenPageStickerListener;
    private ArrayList<StructGroupSticker> categoryStickerList;
    private ViewPager emojisPager;
    public static OnDownloadStickerListener mOnDownloadStickerListener;
    private ArrayList<StructItemSticker> recentStickerList = new ArrayList<>();
    private int dividerColor;
    private int iconColor;
    private static int keepPositionAdapter = 0;

    protected static StickerDatabase getStickerDatabase(Context context) {
        if (stickerDatabase == null) stickerDatabase = new StickerDatabase(context);
        return stickerDatabase;
    }

    public StickerView(final Activity context, int backgroundColor, int iconColor, int dividerColor, final OnPageChangeMainViewPager onChangeViewPager, OnStickerListener onStickerListener, OnDownloadStickerListener onDownloadStickerListener, final OnOpenPageStickerListener onOpenPageStickerListener) {
        super(context);
        View.inflate(context, R.layout.emoji_sticker_view, this);
        this.onChangeViewPager = onChangeViewPager;
        setOrientation(VERTICAL);

        this.myOnOpenPageStickerListener = onOpenPageStickerListener;
        this.mOnDownloadStickerListener = onDownloadStickerListener;
        this.dividerColor = dividerColor;
        this.iconColor = iconColor;
        if (backgroundColor != 0) {
            setBackgroundColor(backgroundColor);
        } else {
            setBackgroundColor(ContextCompat.getColor(context, R.color.emoji_background));
        }

        final View emojiDivider = findViewById(R.id.emojiDivider);
        if (dividerColor != 0) {
            emojiDivider.setBackgroundColor(dividerColor);
        } else {
            emojiDivider.setBackgroundColor(getResources().getColor(R.color.emoji_divider));
        }

        ImageView setting = findViewById(R.id.imgStickerSetting);
        if (iconColor != 0) {
            setting.setColorFilter(iconColor, PorterDuff.Mode.SRC_IN);
        } else {
            setting.setColorFilter(R.color.emoji_background_sticker_tab, PorterDuff.Mode.SRC_IN);
        }
        setting.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onOpenPageStickerListener != null)
                    onOpenPageStickerListener.openSetting(categoryStickerList, getStickerDatabase(context).getRecentlySticker());
            }
        });

        ImageView imgSmilePage = findViewById(R.id.imgEmojiPage);
        if (iconColor != 0) {
            imgSmilePage.setColorFilter(iconColor, PorterDuff.Mode.SRC_IN);
        } else {
            imgSmilePage.setColorFilter(R.color.emoji_background_sticker_tab, PorterDuff.Mode.SRC_IN);
        }
        imgSmilePage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onChangeViewPager != null) onChangeViewPager.changePage();
            }
        });

        categoryStickerList = new ArrayList<>();

        categoryStickerList.add(0, new StructGroupSticker());

        rcvTab = findViewById(R.id.rcvTabImageSticker);
        emojisPager = findViewById(R.id.stickerPager);

        emojisPager.addOnPageChangeListener(this);

        /**
         * addSticker sticker
         */
        recentStickerList = getStickerDatabase(context).getRecentlySticker();

        stickerPagerAdapter = new StickerPagerAdapter(context, backgroundColor, iconColor, dividerColor, categoryStickerList, onChangeViewPager, onStickerListener, recentStickerList, onDownloadStickerListener);

        final int startIndex = recentStickerList.size() > 0 ? 0 : 1;
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(categoryStickerList, emojisPager, startIndex);

        myRecyclerViewAdapter.indexItemSelect = 0;

        rcvTab.setAdapter(myRecyclerViewAdapter);
        rcvTab.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        emojisPager.setOffscreenPageLimit(0);
        emojisPager.setAdapter(stickerPagerAdapter);
        emojisPager.setCurrentItem(startIndex);
        if (keepPositionAdapter != 0) {
            onPageSelected(keepPositionAdapter);
        } else {
            onPageSelected(startIndex);
        }

    }


    @Override
    public void onPageSelected(final int i) {

        if (stickerTabLastSelectedIndex != i) {

            if (i == 0) {
                resetRecentlySticker();
            }

            if (i > myRecyclerViewAdapter.lastIndexSelect && i < (categoryStickerList.size() - 2)) {
                rcvTab.smoothScrollToPosition(i + 2);
            } else if (i > 0 && i < myRecyclerViewAdapter.lastIndexSelect){
                rcvTab.smoothScrollToPosition(i - 1);
            }else {
                rcvTab.smoothScrollToPosition(i);
            }
            stickerTabLastSelectedIndex = i;
            myRecyclerViewAdapter.indexItemSelect = i;
            myRecyclerViewAdapter.notifyItemChanged(myRecyclerViewAdapter.lastIndexSelect);
            myRecyclerViewAdapter.notifyItemChanged(i);


        }

    }

    private void resetRecentlySticker() {
        stickerPagerAdapter.invalidateRecentStickers(getStickerDatabase(getContext()).getRecentlySticker());

    }

    @Override
    public void onPageScrolled(final int i, final float v, final int i2) {
        // No-op.
    }

    @Override
    public void onPageScrollStateChanged(final int i) {
        // No-op.
    }

    public class MyRecyclerViewAdapter extends RecyclerView.Adapter {
        private ArrayList<StructGroupSticker> mData;
        private ViewPager emojisPager;
        public int indexItemSelect = 0;
        private int lastIndexSelect;

        MyRecyclerViewAdapter(ArrayList<StructGroupSticker> data, ViewPager emojisPager, int startIndex) {
            this.mData = data;
            this.emojisPager = emojisPager;
            this.indexItemSelect = startIndex;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            RecyclerView.ViewHolder holder;
            if (viewType == StructGroupSticker.ANIMATED_STICKER) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emoji_lottie_category, parent, false);
                holder = new LottieViewHolder(view);
            } else {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emoji_category, parent, false);
                holder = new NormalViewHolder(view);
            }
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof LottieViewHolder) {
                final LottieViewHolder lottieViewHolder = (LottieViewHolder) holder;

                final StructGroupSticker item = mData.get(position);

                final String path = item.getUri();
                String token = item.getAvatarToken();

                if (new File(path).exists()) {
                    try {
                        lottieViewHolder.stickerView.setAnimation(new FileInputStream(path), token);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (mOnDownloadStickerListener != null)
                        mOnDownloadStickerListener.downloadStickerAvatar(item.getAvatarToken(), item.getName(), item.getAvatarSize(), new OnStickerAvatarDownloaded() {
                            @Override
                            public void onStickerAvatarDownload(String token) {
                                if (token.equals(item.getAvatarToken())) {
                                    try {
                                        lottieViewHolder.stickerView.setAnimation(new FileInputStream(path), token);
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                }
            } else {
                final NormalViewHolder normalViewHolder = (NormalViewHolder) holder;
                if (position >= mData.size()) {
                    normalViewHolder.imgSticker.setImageResource(R.drawable.emoji_add);
                    normalViewHolder.itemView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    if (iconColor != 0) {
                        normalViewHolder.imgSticker.setColorFilter(iconColor, PorterDuff.Mode.SRC_IN);
                    } else {
                        normalViewHolder.imgSticker.setColorFilter(R.color.emoji_background_sticker_tab, PorterDuff.Mode.SRC_IN);
                    }
                    return;
                }

                final StructGroupSticker item = mData.get(position);
                if (position == 0) {
                    normalViewHolder.imgSticker.setImageResource(R.drawable.emoji_recent);
                    if (iconColor != 0) {
                        normalViewHolder.imgSticker.setColorFilter(iconColor, PorterDuff.Mode.SRC_IN);
                    } else {
                        normalViewHolder.imgSticker.setColorFilter(R.color.emoji_background_sticker_tab, PorterDuff.Mode.SRC_IN);
                    }
                } else {

                    normalViewHolder.imgSticker.setImageBitmap(null);
                    if (item.getUri() == null) return;

                    keepPositionAdapter = position;

                    normalViewHolder.imgSticker.clearColorFilter();

                    Log.i(getClass().getName(), "onBindViewHolder: " + mData.get(position).getUri() + " name " + mData.get(position).getName() + " pos " + position);

                    if (new File(item.getUri()).exists()) {
                        Glide.with(holder.itemView.getContext())
                                .load(item.getUri()) // Uri of the picture
                                .apply(new RequestOptions().override(48, 48))
                                .into(normalViewHolder.imgSticker);

                    } else {
                        if (mOnDownloadStickerListener != null)
                            mOnDownloadStickerListener.downloadStickerAvatar(item.getAvatarToken(), item.getName(), item.getAvatarSize(), new OnStickerAvatarDownloaded() {
                                @Override
                                public void onStickerAvatarDownload(String token) {
                                    if (token.equals(item.getAvatarToken())) {
                                        Glide.with(holder.itemView.getContext())
                                                .load(item.getUri()) // Uri of the picture
                                                .apply(new RequestOptions().override(48, 48))
                                                .into(normalViewHolder.imgSticker);
                                    }
                                }
                            });
                    }
                }

                if (indexItemSelect == position) {
                    holder.itemView.setBackgroundColor(getResources().getColor(R.color.emoji_background_sticker_tab));
                    lastIndexSelect = position;
                } else {
                    holder.itemView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                }
            }
        }

        @Override
        public int getItemCount() {
            return mData.size() + 1;
        }

        public void updateStickerAdapter(ArrayList<StructGroupSticker> categoryStickerList) {
            this.mData = categoryStickerList;
            notifyDataSetChanged();
        }

        @Override
        public int getItemViewType(int position) {
            // TODO: 12/17/19 must drawable icon add with viewHolder
            if (mData.size() > 1 && position < mData.size() - 2)
                return mData.get(position).getStickerType();
            else
                return StructGroupSticker.NORMAL_STICKER;
        }

        public class NormalViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
            ImageButton imgSticker;

            NormalViewHolder(View itemView) {
                super(itemView);
                imgSticker = itemView.findViewById(R.id.imgTab);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {

                if (getAdapterPosition() >= mData.size()) {
                    if (myOnOpenPageStickerListener != null) {
                        myOnOpenPageStickerListener.addSticker("ADD");
                    } else {
                        Toast.makeText(itemView.getContext(), "something is wrong", Toast.LENGTH_SHORT).show();
                    }
                    return;
                }
                emojisPager.setCurrentItem(getAdapterPosition());
                rcvTab.smoothScrollToPosition(getAdapterPosition());
                indexItemSelect = getAdapterPosition();
            }
        }

        public class LottieViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
            LottieAnimationView stickerView;

            LottieViewHolder(View itemView) {
                super(itemView);
                stickerView = itemView.findViewById(R.id.lv_category_image);

                stickerView.setFailureListener(new LottieListener<Throwable>() {
                    @Override
                    public void onResult(Throwable result) {
                        Log.e(getClass().getName(), "onResult: ", result);
                    }
                });

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {

                if (getAdapterPosition() >= mData.size()) {
                    if (myOnOpenPageStickerListener != null) {
                        myOnOpenPageStickerListener.addSticker("ADD");
                    } else {
                        Toast.makeText(itemView.getContext(), "something is wrong", Toast.LENGTH_SHORT).show();
                    }
                    return;
                }
                emojisPager.setCurrentItem(getAdapterPosition());
                rcvTab.smoothScrollToPosition(getAdapterPosition());
                indexItemSelect = getAdapterPosition();
            }
        }
    }

    public void updateListStickers(ArrayList<StructGroupSticker> structAllStickers) {

        if (structAllStickers != null) {
            categoryStickerList = new ArrayList<>();
            categoryStickerList.addAll(structAllStickers);
            categoryStickerList.add(0, new StructGroupSticker());
            updateStickerList();
        }
    }

    private void updateStickerList() {

        stickerPagerAdapter.updateStickerAdapter(categoryStickerList);
        myRecyclerViewAdapter.updateStickerAdapter(categoryStickerList);
        onPageSelected(0);
        if (emojisPager != null)
            emojisPager.setCurrentItem(0);
    }

    public void onUpdateRecentSticker(ArrayList<String> structAllStickers) {

        for (String item : structAllStickers) {
            getStickerDatabase(getContext()).removeRecentSticker(item);
        }
        resetRecentlySticker();
    }

}
