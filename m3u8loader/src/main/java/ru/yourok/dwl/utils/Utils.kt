package ru.yourok.dwl.utils

object Utils {
    fun byteFmt(bytes: Double): String {
        if (bytes < 1024)
            return bytes.toString() + " B"
        val exp = (Math.log(bytes) / Math.log(1024.0)).toInt()
        val pre = "KMGTPE"[exp - 1].toString()
        return "%.1f %sB".format(bytes / Math.pow(1024.0, exp.toDouble()), pre)
    }

    fun byteFmt(bytes: Float): String {
        return byteFmt(bytes.toDouble())
    }

    fun byteFmt(bytes: Long): String {
        return byteFmt(bytes.toDouble())
    }

    fun byteFmt(bytes: Int): String {
        return byteFmt(bytes.toDouble())
    }

    fun durationFmt(duration: Float): String {
        if ((duration / 3600).toInt() == 0)
            return "%02d:%02d".format(((duration % 3600) / 60).toInt(), (duration % 60).toInt())
        else
            return "%d:%02d:%02d".format((duration / 3600).toInt(), ((duration % 3600) / 60).toInt(), (duration % 60).toInt())
    }

//    fun saveSettings() {
//        val path = App.getContext().filesDir?.path
//        if (!path.isNullOrEmpty())
//            Saver.save(File(path, "settings.cfg").path, Settings)
//    }
//
//    fun loadSettings() {
//        try {
//            val path = App.getContext().filesDir?.path
//            if (!path.isNullOrEmpty()) {
//                val file = File(path, "settings.cfg")
//                if (!file.exists())
//                    return
//                val vals = Saver.load<LinkedHashMap<*, *>>(file.path)
//                Settings.threads = vals["threads"] as Int
//                Settings.errorRepeat = vals["errorRepeat"] as Int
//
//                Settings.downloadPath = vals["downloadPath"] as String
//                Settings.preloadSize = vals["preloadSize"] as Boolean
//                Settings.convertVideo = vals["convertVideo"] as Boolean
//
//                Settings.headers = mutableMapOf()
//                if (vals["headers"] != null)
//                    Settings.headers = (vals["headers"] as LinkedHashMap<String, String>).toMutableMap()
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//
//    fun removeList(list: List) {
//        var path = App.getContext().filesDir
//        path = java.io.File(path, list.title + ".lst")
//        if (path.exists()) path.delete()
//    }
//
//    fun saveList(list: List) {
//        var path = App.getContext().filesDir?.path
//        path = java.io.File(path, list.title + ".lst").path
//        Saver.save(path, list)
//    }
//
//    fun loadLists(): MutableList<List>? {
//        try {
//            val lists: MutableList<List> = mutableListOf()
//            var path = App.getContext().filesDir
//            if (path != null)
//                path.walk().forEach {
//                    if (it.path.endsWith(".lst")) {
//                        if (it.isFile) {
//                            try {
//                                val list = Saver.load<List>(it.path)
//                                lists.add(list)
//                            } catch (e: Exception) {
//                                it.delete()
//                            }
//                        }
//                    }
//                }
//            return lists
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        return null
//    }
}
//
//object Saver {
//    fun save(filePath: String, clazz: Any) {
//        val mapper = jacksonObjectMapper()
//        mapper.writerWithDefaultPrettyPrinter().writeValue(File(filePath), clazz)
//    }
//
//    inline fun <reified T : Any> load(path: String): T {
//        val mapper = jacksonObjectMapper()
//        return mapper.readValue<T>(File(path))
//    }
//}