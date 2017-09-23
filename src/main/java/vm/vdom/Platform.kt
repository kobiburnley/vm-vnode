package vm.vdom

enum class Platform {
    WEB, ANDROID, iOS, UNKNOWN;

    companion object {
        var platform: Platform = UNKNOWN
    }
}