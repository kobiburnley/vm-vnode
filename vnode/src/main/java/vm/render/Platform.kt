package vm.render

enum class Platform {
    WEB, ANDROID, iOS, UNKNOWN;

    companion object {
        var platform: Platform = UNKNOWN
    }
}