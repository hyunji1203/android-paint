package woowacourse.paint

class Paintings(private val _paintings: MutableList<Painting> = mutableListOf()) {
    val painting: List<Painting> = _paintings

    fun storePainting(painting: Painting) {
        _paintings.add(painting)
    }
}
