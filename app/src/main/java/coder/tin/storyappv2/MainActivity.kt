package coder.tin.storyappv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)
        val storyTitle = resources.getStringArray(R.array.storyTitle)
        val storyContent = resources.getStringArray(R.array.storyContents)
        val storyImage = resources.getStringArray(R.array.storyImages)
        val adapter = ItemAdpater(storyTitle,storyContent,storyImage)
        storyList.layoutManager = Lin-earLayoutManager(this)
        storyList.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}