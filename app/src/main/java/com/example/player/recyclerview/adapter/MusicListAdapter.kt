package com.example.player.recyclerview.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.player.DataClass
import com.example.player.databinding.SongItemBinding



class MusicListAdapter(
    private val songs: List<DataClass.Musica>
): RecyclerView.Adapter<MusicListAdapter.MusicViewHolder>() {


    class MusicViewHolder(private val
        binding: SongItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(musica: DataClass.Musica) {
            binding.nomemusica.text = musica.nome
            binding.artista.text = musica.artista
//            binding.miniatura.setImageResource(musica.miniatura)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicViewHolder {
        return MusicViewHolder(
            SongItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = songs.size

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(songs[position])
    }
}