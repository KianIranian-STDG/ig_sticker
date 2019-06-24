package com.vanniktech.emoji.sticker;

public interface OnUpdateStickerListener {
    void downloadStickerItem(String token, String extention, long avatarSize, OnStickerItemDownloaded onStickerItemDownloaded);
    void downloadStickerAvatar(String token, String extention, long avatarSize, OnStickerAvatarDownloaded onStickerAvatarDownloaded);

    void onUpdateRecentSticker();

}
