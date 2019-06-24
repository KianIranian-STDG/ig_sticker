package com.vanniktech.emoji;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.vanniktech.emoji.listeners.OnEmojiBackspaceClickListener;
import com.vanniktech.emoji.listeners.OnEmojiClickListener;
import com.vanniktech.emoji.listeners.OnEmojiLongClickListener;
import com.vanniktech.emoji.sticker.OnOpenPageStickerListener;
import com.vanniktech.emoji.sticker.OnPageChangeMainViewPager;
import com.vanniktech.emoji.sticker.OnStickerListener;
import com.vanniktech.emoji.sticker.OnDownloadStickerListener;
import com.vanniktech.emoji.sticker.StickerView;
import com.vanniktech.emoji.sticker.struct.StructGroupSticker;

import java.util.ArrayList;



public final class MianPagerAdapter extends PagerAdapter {
    private static final int EMOJI_POSITION = 0;
    private static final int STICKER_POSITION = 1;

    private RecentEmojiGridView recentEmojiGridView;
    private Activity context;
    private OnEmojiClickListener clickListener;
    private OnEmojiLongClickListener longClickListener;
    private RecentEmoji recentEmoji;
    private VariantEmoji variantEmoji;
    private int backgroundColor;
    private int iconColor;
    private int dividerColor;
    private OnPageChangeMainViewPager onChangeViewPager;
    private OnStickerListener onStickerListener;
    private OnDownloadStickerListener onDownloadStickerListener;
    private OnOpenPageStickerListener onOpenPageStickerListener;
    private OnEmojiBackspaceClickListener onEmojiBackspaceClickListener;
    private StickerView stickerView;
    private ViewPager.PageTransformer pageTransformer;

    public MianPagerAdapter(Activity context, OnEmojiClickListener onEmojiClickListener, OnEmojiLongClickListener onEmojiLongClickListener, RecentEmoji recentEmoji, VariantEmoji variantManager, int backgroundColor, int iconColor, int dividerColor, OnEmojiBackspaceClickListener onEmojiBackspaceClickListener, OnPageChangeMainViewPager onChangeViewPager, OnStickerListener onStickerListener, OnDownloadStickerListener onDownloadStickerListener, OnOpenPageStickerListener onOpenPageStickerListener, ViewPager.PageTransformer pageTransformer) {
        this.context = context;
        this.clickListener = onEmojiClickListener;
        this.longClickListener = onEmojiLongClickListener;
        this.recentEmoji = recentEmoji;
        this.variantEmoji = variantManager;
        this.backgroundColor = backgroundColor;
        this.iconColor = iconColor;
        this.dividerColor = dividerColor;
        this.onChangeViewPager = onChangeViewPager;
        this.onStickerListener = onStickerListener;
        this.onDownloadStickerListener = onDownloadStickerListener;
        this.onEmojiBackspaceClickListener = onEmojiBackspaceClickListener;
        this.onOpenPageStickerListener = onOpenPageStickerListener;
        this.pageTransformer = pageTransformer;

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object instantiateItem(final ViewGroup pager, final int position) {
        final View newView;

        if (position == EMOJI_POSITION) {
            newView = new EmojiView(context, clickListener, longClickListener, recentEmoji, variantEmoji, backgroundColor, iconColor, dividerColor, onEmojiBackspaceClickListener,onChangeViewPager,pageTransformer);
        } else { // STICKER_POSITION
            stickerView = new StickerView(context, backgroundColor, iconColor, dividerColor, onChangeViewPager, onStickerListener, onDownloadStickerListener, onOpenPageStickerListener);
            newView = stickerView;
        }

        pager.addView(newView);
        return newView;
    }

    @Override
    public void destroyItem(final ViewGroup pager, final int position, final Object view) {
        pager.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
    }

    public void updateSticker(final ArrayList<StructGroupSticker> structAllStickers){

        if (stickerView ==null){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (stickerView !=null) stickerView.updateListStickers(structAllStickers);
                }
            },2000);
        }else {
             stickerView.updateListStickers(structAllStickers);
        }
    }

    public void onUpdateRecentSticker(ArrayList<String> structAllStickers) {
        stickerView.onUpdateRecentSticker(structAllStickers);
    }

}
