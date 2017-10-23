package vm.component

import iview.IPopupMenu


interface IActivity {
    fun openFragment(fragment: Any, addToBackStack: String)
    fun onBackPressed()
    fun popupMenu(anchor: Any): IPopupMenu
}