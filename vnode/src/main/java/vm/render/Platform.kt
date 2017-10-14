package vm.render

enum class Platform {
    WEB, ANDROID, iOS, UNKNOWN;

    companion object {
        @JvmField var platform: Platform = UNKNOWN
    }
}