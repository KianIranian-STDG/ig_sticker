package com.vanniktech.emoji.sticker;

import com.vanniktech.emoji.sticker.struct.StructGroupSticker;
import com.vanniktech.emoji.sticker.struct.StructItemSticker;

public interface OnDownloadStickerListener {
    void downloadStickerItem(StructItemSticker sticker, OnStickerItemDownloaded onStickerItemDownloaded);

    void downloadLottieStickerItem(StructItemSticker sticker, OnLottieStickerItemDownloaded lottieStickerItemDownloaded);

    void downloadStickerAvatar(StructGroupSticker sticker, OnStickerAvatarDownloaded onStickerAvatarDownloaded);
}
