package edu.ub.pis.joc.limitless.view.login


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.gms.common.SignInButton
import edu.ub.pis.joc.limitless.R

class LoginSignFragment : Fragment() {

    private var listener: OnLoginSignListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_login_sign, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signInButton: SignInButton = view.findViewById(R.id.signin_btn)
        val textView = signInButton.getChildAt(0) as TextView
        textView.text = getString(R.string.cuenta_google_btn)

        signInButton.setOnClickListener {
            onButtonPressed()
        }
    }

    fun onButtonPressed() {
        listener?.onLoginSign()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLoginSignListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentLoginListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnLoginSignListener {
        fun onLoginSign()
    }

}
