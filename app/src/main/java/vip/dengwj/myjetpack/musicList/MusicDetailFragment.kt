package vip.dengwj.myjetpack.musicList

import vip.dengwj.myjetpack.base.BaseFragment

class MusicDetailFragment : BaseFragment() {
    private val musicPresenter by lazy {
        MusicPresenter()
    }

    init {
        lifecycleProvider.addLifeListener(musicPresenter)
    }
}