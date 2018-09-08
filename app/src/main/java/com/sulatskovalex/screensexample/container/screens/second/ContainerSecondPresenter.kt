package com.sulatskovalex.screensexample.container.screens.second

import com.github.sulatskovalex.screens.ChildPresenter
import com.github.sulatskovalex.screens.Router
import com.sulatskovalex.screensexample.CONTAINER_SCREEN_FIRST

class ContainerSecondPresenter(router: Router)
  : ChildPresenter<ContainerSecondPresenter, ContainerSecondScreen, Unit>(router) {

  fun onBackClick() {
    rootRouter.back()
  }

  fun onReplaceClick() {
    childRouter.replace(CONTAINER_SCREEN_FIRST)
  }

  fun onForwardClick() {
    childRouter.forward(CONTAINER_SCREEN_FIRST)
  }
}