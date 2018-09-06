package com.fuzail.roomexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {
private EditText userId,userName,userEmail;
private Button BnUpdate;

    public UpdateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);

        userId=view.findViewById(R.id.txt_user_id);
        userName=view.findViewById(R.id.txt_name);
        userEmail=view.findViewById(R.id.txt_email);
        BnUpdate=view.findViewById(R.id.bn_update_user);

        BnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(userId.getText().toString());
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();

                User user = new User();

                //to check if a userid is already present or not
                User test = MainActivity.myAppDatabase.myDao().checkUser(id);
                if (test != null) {
                    user.setId(id);
                    user.setName(name);
                    user.setEmail(email);

                    MainActivity.myAppDatabase.myDao().updateUser(user);
                    Toast.makeText(getActivity(), "User Updated", Toast.LENGTH_LONG).show();

                    userId.setText("");
                    userName.setText("");
                    userEmail.setText("");
                }
                else
                    Toast.makeText(getActivity(), "User Id Not Found", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
