package edu.ub.pis.joc.limitless.view.login


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.ub.pis.joc.limitless.R
import edu.ub.pis.joc.limitless.view.ViewAdjuster

class LoginWaitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_login_wait, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewAdjuster.adjustView(view.findViewById(R.id.loading_tv))
        ViewAdjuster.adjustView(view.findViewById(R.id.login_progress))
    }

}
