package org.d3if3038.mindfinderadmin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import org.d3if3038.mindfinderadmin.R
import org.d3if3038.mindfinderadmin.databinding.FragmentResultBinding
import org.d3if3038.mindfinderadmin.model.PersonalityCategories

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    private val resultArgs: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var personalityType = ""
        var personalityExpl = ""

        when (resultArgs.personalityType) {
            PersonalityCategories.TYPE_D -> {
                personalityType = getString(R.string.type_d)
                personalityExpl = getString(R.string.personality_d)
                binding.personalityImage.setImageResource(R.drawable.personality_dominance)
            }
            PersonalityCategories.TYPE_I -> {
                personalityType = getString(R.string.type_i)
                personalityExpl = getString(R.string.personality_i)
                binding.personalityImage.setImageResource(R.drawable.personality_influence)
            }
            PersonalityCategories.TYPE_S -> {
                personalityType = getString(R.string.type_s)
                personalityExpl = getString(R.string.personality_s)
                binding.personalityImage.setImageResource(R.drawable.personality_steady)
            }
            PersonalityCategories.TYPE_C -> {
                personalityType = getString(R.string.type_c)
                personalityExpl = getString(R.string.personality_c)
                binding.personalityImage.setImageResource(R.drawable.personality_conscientiousness)
            }
        }

        binding.resultNameTextView.text = resultArgs.fullName
        binding.personalityTitleTextView.text = personalityType
        binding.explanationTextView.text = personalityExpl
    }
}