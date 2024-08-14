package vip.dengwj.myjetpack.musicList

import vip.dengwj.myjetpack.musicList.domain.Music

class MusicModel {
    fun getMusicList(page: Int, size: Int, callback: OnGetMusicListener) {
        Thread {
            // 发送网络请求，获取到数据
            val list = arrayListOf<Music>()
            for (item in (page..size)) {
                list.add(
                    Music(
                        "歌名 -> $item",
                        "封面 -> $item",
                        "url -> $item"
                    )
                )
            }
            callback.onSuccess(list)
        }.start()
    }

    interface OnGetMusicListener {
        fun onSuccess(list: List<Music>)

        fun onError(msg: String)
    }
}