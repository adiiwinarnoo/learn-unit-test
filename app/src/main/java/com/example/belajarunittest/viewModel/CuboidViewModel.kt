package com.example.belajarunittest.viewModel

import com.example.belajarunittest.model.CuboidModel

class CuboidViewModel ( private val cuboidModel: CuboidModel ) {
    fun getCircumference() = cuboidModel.getCircumference()
    fun getSurfaceArea() = cuboidModel.getSurfaceArea()
    fun getVolume() = cuboidModel.getVolume()
    fun save(w: Double, l: Double, h: Double) {
        cuboidModel.save(w, l, h)
    }
}