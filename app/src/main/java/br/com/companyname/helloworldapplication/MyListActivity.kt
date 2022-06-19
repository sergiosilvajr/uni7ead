package br.com.companyname.helloworldapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_my_list.*

class MyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my_list)
        val list = sample_list
        list.adapter = MyListAdapter(getList())
        list.layoutManager = LinearLayoutManager(this)
    }

    private fun getList(): List<Aluno> = listOf(
        Aluno(
            "Primeiro nome",
            "https://cdn.pixabay.com/photo/2015/03/04/22/35/avatar-659652_1280.png"
        ),
        Aluno(
            "Segundo Nome",
            "https://cdn.pixabay.com/photo/2015/03/04/22/35/avatar-659652_1280.png"
        ),
        Aluno(
            "Terceiro nome",
            "https://cdn.pixabay.com/photo/2015/03/04/22/35/avatar-659652_1280.png"
        )
    )
}