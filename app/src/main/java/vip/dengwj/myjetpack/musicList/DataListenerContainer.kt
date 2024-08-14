package vip.dengwj.myjetpack.musicList

/**
 * 数据容器
 * 可以监听数据的变化
 */
class DataListenerContainer<T> {
    private val blocks = arrayListOf<(T) -> Unit>()

    // 数据改变
    var value: T? = null
        set(value) {
            field = value
            blocks.forEach {
                if (value != null) it.invoke(value)
            }
        }

    fun addListener(block: (T) -> Unit) {
        if (!blocks.contains(block)) {
            blocks.add(block)
        }
    }
}