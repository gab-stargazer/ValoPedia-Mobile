package com.lelestacia.valorantgamepedia.ui.agents

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lelestacia.valorantgamepedia.R
import com.lelestacia.valorantgamepedia.data.model.remote.AgentData
import com.lelestacia.valorantgamepedia.databinding.AgentsItemBinding
import com.lelestacia.valorantgamepedia.ui.agents.agents_detail.AgentsDetailActivity

class AgentsAdapter : ListAdapter<AgentData, AgentsAdapter.AgentsViewHolder>(DIFF_CALLBACK) {

    inner class AgentsViewHolder(private val binding: AgentsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AgentData) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(item.displayIcon)
                    .placeholder(R.drawable.ic_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .error(R.drawable.ic_broken_image)
                    .fitCenter()
                    .into(ivAgentIcon)

                Glide.with(itemView.context)
                    .load(item.role?.displayIcon)
                    .placeholder(R.drawable.ic_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .error(R.drawable.ic_broken_image)
                    .fitCenter()
                    .into(ivAgentRole)

                tvAgentName.text = item.displayName
                tvAgentRoleTitle.text = item.role?.displayName ?: "Empty Role"

                binding.root.setOnClickListener {
                    with(itemView.context) {
                        startActivity(Intent(this, AgentsDetailActivity::class.java).also {
                            it.putExtra("AGENT", item)
                        })
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentsViewHolder {
        val binding = AgentsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AgentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null)
            holder.bind(item)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<AgentData>() {
            override fun areItemsTheSame(oldItem: AgentData, newItem: AgentData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: AgentData, newItem: AgentData): Boolean {
                return oldItem.uuid == newItem.uuid
            }

        }
    }
}