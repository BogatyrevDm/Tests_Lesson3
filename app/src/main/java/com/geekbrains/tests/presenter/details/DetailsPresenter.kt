package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.view.ViewContract
import com.geekbrains.tests.view.details.ViewDetailsContract

internal class DetailsPresenter internal constructor(
    private var viewContract: ViewDetailsContract?,
    private var count: Int = 0
) : PresenterDetailsContract {

    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement() {
        count++
        viewContract!!.setCount(count)
    }

    override fun onDecrement() {
        count--
        viewContract!!.setCount(count)
    }

    fun getView() = viewContract

    override fun onAttach(view: ViewContract) {
        if (viewContract == null) {
            viewContract = view as ViewDetailsContract
        }
    }

    override fun onDetach(view: ViewContract) {
        viewContract = null
    }
}
