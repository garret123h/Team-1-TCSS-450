package edu.uw.tcss450.chatapp_group1.ui.auth.signin;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.uw.tcss450.chatapp_group1.R;
import edu.uw.tcss450.chatapp_group1.databinding.FragmentLostPasswordBinding;
import edu.uw.tcss450.chatapp_group1.utils.PasswordValidator;

import static edu.uw.tcss450.chatapp_group1.utils.PasswordValidator.checkExcludeWhiteSpace;
import static edu.uw.tcss450.chatapp_group1.utils.PasswordValidator.checkPwdLength;
import static edu.uw.tcss450.chatapp_group1.utils.PasswordValidator.checkPwdSpecialChar;

/**
 * A simple {@link Fragment} subclass.
 */
public class LostPasswordFragment extends Fragment {

    private FragmentLostPasswordBinding binding;
    private LostPasswordViewModel mLostPasswordViewModel;
    private PasswordValidator mEmailValidator = checkPwdLength(2)
            .and(checkExcludeWhiteSpace())
            .and(checkPwdSpecialChar("@"));



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLostPasswordViewModel = new ViewModelProvider(getActivity())
                .get(LostPasswordViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLostPasswordBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.cancelButton.setOnClickListener(this::navigateBackToSignIn);
        binding.sendEmailButton.setOnClickListener(this::attemptToSendPassword);

        mLostPasswordViewModel.addResponseObserver(
                getViewLifecycleOwner(),
                this::observeSignInResponse);

        LostPasswordFragmentArgs args = LostPasswordFragmentArgs.fromBundle(getArguments());
        binding.emailTextField.setText(args.getEmail());
    }

    private void observeSignInResponse(JSONObject response) {
        if (response.length() > 0) {
            if (response.has("code")) {
                try {
                    binding.emailTextField.setError(
                            "Error Authenticating: " +
                                    response.getJSONObject("data").getString("message"));
                } catch (JSONException e) {
                    Log.e("JSON Parse Error", e.getMessage());
                }
            } else {
                navigateBackToSignIn(null);
                Toast.makeText(getActivity(),
                        "Email sent to: " + binding.emailTextField.getText().toString(),
                        Toast.LENGTH_LONG).show();

                // The following hides the keyboard (bc it's annoying that it stays up)
                ((InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

            }
        } else {
            Log.d("JSON Response", "No Response");
        }
    }


    /**
     * Attempts to reset password by first validating the email in the text field
     * @param view Text view parameter required to let this be an action listener.
     */
    private void attemptToSendPassword(View view) {
        String emailText = binding.emailTextField.getText().toString();

        mEmailValidator.processResult(
                mEmailValidator.apply(emailText),
                this::validEmailResetPassword,
                result -> binding.emailTextField.setError("Please enter a valid Email address."));
    }


    /**
     * Sends request to reset password
     */
    private void validEmailResetPassword() {
        mLostPasswordViewModel.connect(binding.emailTextField.getText().toString());
    }

    /**
     * Returns to the sign in page
     */
    private void navigateBackToSignIn(View view) {
        Navigation.findNavController(getView()).navigate(
                LostPasswordFragmentDirections
                        .actionLostPasswordFragmentToSignInFragment());

        Navigation.findNavController(requireView()).popBackStack(
                R.id.lostPasswordFragment, true);
    }

}