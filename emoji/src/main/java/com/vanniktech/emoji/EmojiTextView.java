package com.vanniktech.emoji;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.CallSuper;
import androidx.annotation.DimenRes;
import androidx.annotation.Px;
import androidx.appcompat.widget.AppCompatTextView;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;

@SuppressWarnings("CPD-START") public class EmojiTextView extends AppCompatTextView {
  private float emojiSize;
  private boolean hasEmoji;

  public EmojiTextView(final Context context) {
    this(context, null);
    setHasEmoji(true);
  }

  public EmojiTextView(final Context context, final AttributeSet attrs) {
    super(context, attrs);
    setHasEmoji(true);
    if (!isInEditMode()) {
      EmojiManager.getInstance().verifyInstalled();
    }

    final Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
    final float defaultEmojiSize = fontMetrics.descent - fontMetrics.ascent;

    if (attrs == null) {
      emojiSize = defaultEmojiSize;
    } else {
      final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.EmojiTextView);

      try {
        emojiSize = a.getDimension(R.styleable.EmojiTextView_emojiSize, defaultEmojiSize);
      } finally {
        a.recycle();
      }
    }

    setText(getText());
  }

  @Override @CallSuper public void setText(final CharSequence rawText, final BufferType type) {
    if (hasEmoji) {
      final CharSequence text = rawText == null ? "" : rawText;
      final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
      final Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
      final float defaultEmojiSize = fontMetrics.descent - fontMetrics.ascent;
      EmojiManager.getInstance().replaceWithImages(getContext(), spannableStringBuilder, emojiSize, defaultEmojiSize);
      super.setText(spannableStringBuilder, type);
    } else {
      super.setText(rawText, type);
    }
  }

  /** sets the emoji size in pixels and automatically invalidates the text and renders it with the new size */
  public final void setEmojiSize(@Px final int pixels) {
    setEmojiSize(pixels, true);
  }

  /** sets the emoji size in pixels and automatically invalidates the text and renders it with the new size when {@code shouldInvalidate} is true */
  public final void setEmojiSize(@Px final int pixels, final boolean shouldInvalidate) {
    emojiSize = pixels;

    if (shouldInvalidate) {
      setText(getText());
    }
  }

  /** sets the emoji size in pixels with the provided resource and automatically invalidates the text and renders it with the new size */
  public final void setEmojiSizeRes(@DimenRes final int res) {
    setEmojiSizeRes(res, true);
  }

  /** sets the emoji size in pixels with the provided resource and invalidates the text and renders it with the new size when {@code shouldInvalidate} is true */
  public final void setEmojiSizeRes(@DimenRes final int res, final boolean shouldInvalidate) {
    setEmojiSize(getResources().getDimensionPixelSize(res), shouldInvalidate);
  }

  public boolean getHasEmoji() {
    return hasEmoji;
  }

  public void setHasEmoji(boolean value) {
    hasEmoji = value;
  }
}
