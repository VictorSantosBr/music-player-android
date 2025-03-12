    package com.example.player
    import android.annotation.SuppressLint
    import android.content.Context
    import android.provider.MediaStore
    import android.util.Log

    @SuppressLint("Recycle")
    fun obterMusica(context: Context): List<DataClass.Musica> {

        val listamusica = mutableListOf<DataClass.Musica>()
        val contentresolver = context.contentResolver
        val musicURI = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projecao = arrayOf(
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.ALBUM_ID
        )

        val cursor = contentresolver.query(
            musicURI, projecao, null, null, null
        )
        cursor?.use {
            if (it.moveToFirst()) {
                val indiceTitle = it.getColumnIndex(MediaStore.Audio.Media.TITLE)
                val indiceArtist = it.getColumnIndex(MediaStore.Audio.Media.ARTIST)
                val indiceAlbum = it.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)

                do {
                    val title = it.getString(indiceTitle)
                    val artist = it.getString(indiceArtist)
                    val albumID = it.getLong(indiceAlbum)
                    listamusica.add(DataClass.Musica(title, artist))
                } while (it.moveToNext())
                    //            val albumArt = "content://media/external/audio/albumart/$albumID"
            } else {
                Log.d("MusicList", "Nenhuma música encontrada.")
            }
        } ?: Log.e("MusicList", "Cursor é nulo.")

        return listamusica
    }