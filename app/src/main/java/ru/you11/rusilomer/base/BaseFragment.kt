package ru.you11.rusilomer.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<TViewModel: ViewModel>: Fragment() {

    protected lateinit var viewModel: TViewModel

    abstract fun createViewModel(): TViewModel
}