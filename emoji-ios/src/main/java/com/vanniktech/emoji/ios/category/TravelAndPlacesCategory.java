package com.vanniktech.emoji.ios.category;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import com.vanniktech.emoji.emoji.EmojiCategory;
import com.vanniktech.emoji.ios.R;
import com.vanniktech.emoji.ios.IosEmoji;

@SuppressWarnings("PMD.MethodReturnsInternalArray") public final class TravelAndPlacesCategory implements EmojiCategory {
  private static final IosEmoji[] DATA = new IosEmoji[] {
    new IosEmoji(0x1F30D, 6, 5, false),
    new IosEmoji(0x1F30E, 6, 6, false),
    new IosEmoji(0x1F30F, 6, 7, false),
    new IosEmoji(0x1F310, 6, 8, false),
    new IosEmoji(new int[] { 0x1F5FA, 0xFE0F }, 30, 18, false),
    new IosEmoji(0x1F5FE, 30, 22, false),
    new IosEmoji(new int[] { 0x1F3D4, 0xFE0F }, 11, 37, false),
    new IosEmoji(new int[] { 0x26F0, 0xFE0F }, 48, 38, false),
    new IosEmoji(0x1F30B, 6, 3, false),
    new IosEmoji(0x1F5FB, 30, 19, false),
    new IosEmoji(new int[] { 0x1F3D5, 0xFE0F }, 11, 38, false),
    new IosEmoji(new int[] { 0x1F3D6, 0xFE0F }, 11, 39, false),
    new IosEmoji(new int[] { 0x1F3DC, 0xFE0F }, 11, 45, false),
    new IosEmoji(new int[] { 0x1F3DD, 0xFE0F }, 11, 46, false),
    new IosEmoji(new int[] { 0x1F3DE, 0xFE0F }, 11, 47, false),
    new IosEmoji(new int[] { 0x1F3DF, 0xFE0F }, 11, 48, false),
    new IosEmoji(new int[] { 0x1F3DB, 0xFE0F }, 11, 44, false),
    new IosEmoji(new int[] { 0x1F3D7, 0xFE0F }, 11, 40, false),
    new IosEmoji(new int[] { 0x1F3D8, 0xFE0F }, 11, 41, false),
    new IosEmoji(new int[] { 0x1F3D9, 0xFE0F }, 11, 42, false),
    new IosEmoji(new int[] { 0x1F3DA, 0xFE0F }, 11, 43, false),
    new IosEmoji(0x1F3E0, 11, 49, false),
    new IosEmoji(0x1F3E1, 11, 50, false),
    new IosEmoji(0x1F3E2, 11, 51, false),
    new IosEmoji(0x1F3E3, 12, 0, false),
    new IosEmoji(0x1F3E4, 12, 1, false),
    new IosEmoji(0x1F3E5, 12, 2, false),
    new IosEmoji(0x1F3E6, 12, 3, false),
    new IosEmoji(0x1F3E8, 12, 5, false),
    new IosEmoji(0x1F3E9, 12, 6, false),
    new IosEmoji(0x1F3EA, 12, 7, false),
    new IosEmoji(0x1F3EB, 12, 8, false),
    new IosEmoji(0x1F3EC, 12, 9, false),
    new IosEmoji(0x1F3ED, 12, 10, false),
    new IosEmoji(0x1F3EF, 12, 12, false),
    new IosEmoji(0x1F3F0, 12, 13, false),
    new IosEmoji(0x1F492, 24, 44, false),
    new IosEmoji(0x1F5FC, 30, 20, false),
    new IosEmoji(0x1F5FD, 30, 21, false),
    new IosEmoji(0x26EA, 48, 37, false),
    new IosEmoji(0x1F54C, 28, 15, false),
    new IosEmoji(0x1F54D, 28, 16, false),
    new IosEmoji(new int[] { 0x26E9, 0xFE0F }, 48, 36, false),
    new IosEmoji(0x1F54B, 28, 14, false),
    new IosEmoji(0x26F2, 48, 40, false),
    new IosEmoji(0x26FA, 49, 12, false),
    new IosEmoji(0x1F301, 5, 45, false),
    new IosEmoji(0x1F303, 5, 47, false),
    new IosEmoji(0x1F304, 5, 48, false),
    new IosEmoji(0x1F305, 5, 49, false),
    new IosEmoji(0x1F306, 5, 50, false),
    new IosEmoji(0x1F307, 5, 51, false),
    new IosEmoji(0x1F309, 6, 1, false),
    new IosEmoji(new int[] { 0x2668, 0xFE0F }, 48, 8, false),
    new IosEmoji(0x1F30C, 6, 4, false),
    new IosEmoji(0x1F3A0, 8, 46, false),
    new IosEmoji(0x1F3A1, 8, 47, false),
    new IosEmoji(0x1F3A2, 8, 48, false),
    new IosEmoji(0x1F488, 24, 34, false),
    new IosEmoji(0x1F3AA, 9, 4, false),
    new IosEmoji(0x1F3AD, 9, 7, false),
    new IosEmoji(new int[] { 0x1F5BC, 0xFE0F }, 30, 3, false),
    new IosEmoji(0x1F3A8, 9, 2, false),
    new IosEmoji(0x1F3B0, 9, 10, false),
    new IosEmoji(0x1F682, 34, 10, false),
    new IosEmoji(0x1F683, 34, 11, false),
    new IosEmoji(0x1F684, 34, 12, false),
    new IosEmoji(0x1F685, 34, 13, false),
    new IosEmoji(0x1F686, 34, 14, false),
    new IosEmoji(0x1F687, 34, 15, false),
    new IosEmoji(0x1F688, 34, 16, false),
    new IosEmoji(0x1F689, 34, 17, false),
    new IosEmoji(0x1F68A, 34, 18, false),
    new IosEmoji(0x1F69D, 34, 37, false),
    new IosEmoji(0x1F69E, 34, 38, false),
    new IosEmoji(0x1F68B, 34, 19, false),
    new IosEmoji(0x1F68C, 34, 20, false),
    new IosEmoji(0x1F68D, 34, 21, false),
    new IosEmoji(0x1F68E, 34, 22, false),
    new IosEmoji(0x1F690, 34, 24, false),
    new IosEmoji(0x1F691, 34, 25, false),
    new IosEmoji(0x1F692, 34, 26, false),
    new IosEmoji(0x1F693, 34, 27, false),
    new IosEmoji(0x1F694, 34, 28, false),
    new IosEmoji(0x1F695, 34, 29, false),
    new IosEmoji(0x1F696, 34, 30, false),
    new IosEmoji(0x1F697, 34, 31, false),
    new IosEmoji(0x1F698, 34, 32, false),
    new IosEmoji(0x1F699, 34, 33, false),
    new IosEmoji(0x1F69A, 34, 34, false),
    new IosEmoji(0x1F69B, 34, 35, false),
    new IosEmoji(0x1F69C, 34, 36, false),
    new IosEmoji(0x1F6B2, 35, 23, false),
    new IosEmoji(0x1F6F4, 37, 19, false),
    new IosEmoji(0x1F6F5, 37, 20, false),
    new IosEmoji(0x1F68F, 34, 23, false),
    new IosEmoji(new int[] { 0x1F6E3, 0xFE0F }, 37, 11, false),
    new IosEmoji(new int[] { 0x1F6E4, 0xFE0F }, 37, 12, false),
    new IosEmoji(0x26FD, 49, 13, false),
    new IosEmoji(0x1F6A8, 35, 13, false),
    new IosEmoji(0x1F6A5, 35, 10, false),
    new IosEmoji(0x1F6A6, 35, 11, false),
    new IosEmoji(0x1F6A7, 35, 12, false),
    new IosEmoji(0x1F6D1, 37, 6, false),
    new IosEmoji(0x2693, 48, 12, false),
    new IosEmoji(0x26F5, 48, 43, false),
    new IosEmoji(0x1F6F6, 37, 21, false),
    new IosEmoji(0x1F6A4, 35, 9, false),
    new IosEmoji(new int[] { 0x1F6F3, 0xFE0F }, 37, 18, false),
    new IosEmoji(new int[] { 0x26F4, 0xFE0F }, 48, 42, false),
    new IosEmoji(new int[] { 0x1F6E5, 0xFE0F }, 37, 13, false),
    new IosEmoji(0x1F6A2, 34, 42, false),
    new IosEmoji(new int[] { 0x2708, 0xFE0F }, 49, 16, false),
    new IosEmoji(new int[] { 0x1F6E9, 0xFE0F }, 37, 14, false),
    new IosEmoji(0x1F6EB, 37, 15, false),
    new IosEmoji(0x1F6EC, 37, 16, false),
    new IosEmoji(0x1F4BA, 25, 37, false),
    new IosEmoji(0x1F681, 34, 9, false),
    new IosEmoji(0x1F69F, 34, 39, false),
    new IosEmoji(0x1F6A0, 34, 40, false),
    new IosEmoji(0x1F6A1, 34, 41, false),
    new IosEmoji(new int[] { 0x1F6F0, 0xFE0F }, 37, 17, false),
    new IosEmoji(0x1F680, 34, 8, false),
    new IosEmoji(0x1F6F8, 37, 23, false),
    new IosEmoji(new int[] { 0x1F6CE, 0xFE0F }, 37, 3, false),
    new IosEmoji(0x1F6AA, 35, 15, false),
    new IosEmoji(new int[] { 0x1F6CF, 0xFE0F }, 37, 4, false),
    new IosEmoji(new int[] { 0x1F6CB, 0xFE0F }, 36, 47, false),
    new IosEmoji(0x1F6BD, 36, 33, false),
    new IosEmoji(0x1F6BF, 36, 35, false),
    new IosEmoji(0x1F6C1, 36, 42, false),
    new IosEmoji(0x231B, 46, 42, false),
    new IosEmoji(0x23F3, 47, 3, false),
    new IosEmoji(0x231A, 46, 41, false),
    new IosEmoji(0x23F0, 47, 0, false),
    new IosEmoji(new int[] { 0x23F1, 0xFE0F }, 47, 1, false),
    new IosEmoji(new int[] { 0x23F2, 0xFE0F }, 47, 2, false),
    new IosEmoji(new int[] { 0x1F570, 0xFE0F }, 28, 43, false),
    new IosEmoji(0x1F55B, 28, 29, false),
    new IosEmoji(0x1F567, 28, 41, false),
    new IosEmoji(0x1F550, 28, 18, false),
    new IosEmoji(0x1F55C, 28, 30, false),
    new IosEmoji(0x1F551, 28, 19, false),
    new IosEmoji(0x1F55D, 28, 31, false),
    new IosEmoji(0x1F552, 28, 20, false),
    new IosEmoji(0x1F55E, 28, 32, false),
    new IosEmoji(0x1F553, 28, 21, false),
    new IosEmoji(0x1F55F, 28, 33, false),
    new IosEmoji(0x1F554, 28, 22, false),
    new IosEmoji(0x1F560, 28, 34, false),
    new IosEmoji(0x1F555, 28, 23, false),
    new IosEmoji(0x1F561, 28, 35, false),
    new IosEmoji(0x1F556, 28, 24, false),
    new IosEmoji(0x1F562, 28, 36, false),
    new IosEmoji(0x1F557, 28, 25, false),
    new IosEmoji(0x1F563, 28, 37, false),
    new IosEmoji(0x1F558, 28, 26, false),
    new IosEmoji(0x1F564, 28, 38, false),
    new IosEmoji(0x1F559, 28, 27, false),
    new IosEmoji(0x1F565, 28, 39, false),
    new IosEmoji(0x1F55A, 28, 28, false),
    new IosEmoji(0x1F566, 28, 40, false),
    new IosEmoji(0x1F311, 6, 9, false),
    new IosEmoji(0x1F312, 6, 10, false),
    new IosEmoji(0x1F313, 6, 11, false),
    new IosEmoji(0x1F314, 6, 12, false),
    new IosEmoji(0x1F315, 6, 13, false),
    new IosEmoji(0x1F316, 6, 14, false),
    new IosEmoji(0x1F317, 6, 15, false),
    new IosEmoji(0x1F318, 6, 16, false),
    new IosEmoji(0x1F319, 6, 17, false),
    new IosEmoji(0x1F31A, 6, 18, false),
    new IosEmoji(0x1F31B, 6, 19, false),
    new IosEmoji(0x1F31C, 6, 20, false),
    new IosEmoji(new int[] { 0x1F321, 0xFE0F }, 6, 25, false),
    new IosEmoji(new int[] { 0x2600, 0xFE0F }, 47, 16, false),
    new IosEmoji(0x1F31D, 6, 21, false),
    new IosEmoji(0x1F31E, 6, 22, false),
    new IosEmoji(0x2B50, 50, 22, false),
    new IosEmoji(0x1F31F, 6, 23, false),
    new IosEmoji(0x1F320, 6, 24, false),
    new IosEmoji(new int[] { 0x2601, 0xFE0F }, 47, 17, false),
    new IosEmoji(0x26C5, 48, 29, false),
    new IosEmoji(new int[] { 0x26C8, 0xFE0F }, 48, 30, false),
    new IosEmoji(new int[] { 0x1F324, 0xFE0F }, 6, 26, false),
    new IosEmoji(new int[] { 0x1F325, 0xFE0F }, 6, 27, false),
    new IosEmoji(new int[] { 0x1F326, 0xFE0F }, 6, 28, false),
    new IosEmoji(new int[] { 0x1F327, 0xFE0F }, 6, 29, false),
    new IosEmoji(new int[] { 0x1F328, 0xFE0F }, 6, 30, false),
    new IosEmoji(new int[] { 0x1F329, 0xFE0F }, 6, 31, false),
    new IosEmoji(new int[] { 0x1F32A, 0xFE0F }, 6, 32, false),
    new IosEmoji(new int[] { 0x1F32B, 0xFE0F }, 6, 33, false),
    new IosEmoji(new int[] { 0x1F32C, 0xFE0F }, 6, 34, false),
    new IosEmoji(0x1F300, 5, 44, false),
    new IosEmoji(0x1F308, 6, 0, false),
    new IosEmoji(0x1F302, 5, 46, false),
    new IosEmoji(new int[] { 0x2602, 0xFE0F }, 47, 18, false),
    new IosEmoji(0x2614, 47, 23, false),
    new IosEmoji(new int[] { 0x26F1, 0xFE0F }, 48, 39, false),
    new IosEmoji(0x26A1, 48, 21, false),
    new IosEmoji(new int[] { 0x2744, 0xFE0F }, 49, 51, false),
    new IosEmoji(new int[] { 0x2603, 0xFE0F }, 47, 19, false),
    new IosEmoji(0x26C4, 48, 28, false),
    new IosEmoji(new int[] { 0x2604, 0xFE0F }, 47, 20, false),
    new IosEmoji(0x1F525, 27, 39, false),
    new IosEmoji(0x1F4A7, 25, 13, false),
    new IosEmoji(0x1F30A, 6, 2, false)
  };

  @Override @NonNull public IosEmoji[] getEmojis() {
    return DATA;
  }

  @Override @DrawableRes public int getIcon() {
    return R.drawable.emoji_ios_category_travelandplaces;
  }

  @Override @StringRes public int getCategoryName() {
    return R.string.emoji_ios_category_travelandplaces;
  }
}
