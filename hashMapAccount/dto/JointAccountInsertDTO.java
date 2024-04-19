package gr.aueb.cf.myPractice.hashMapAccount.dto;

import gr.aueb.cf.myPractice.hashMapAccount.model.User;

public class JointAccountInsertDTO extends AccountInsertDTO {

    private UserInsertDTO secondHolderInsertDTO;

    public JointAccountInsertDTO() {
    }


    public UserInsertDTO getSecondHolderInsertDTO() {
        return secondHolderInsertDTO;
    }

    public void setSecondHolderInsertDTO(UserInsertDTO secondHolderInsertDTO) {
        this.secondHolderInsertDTO = secondHolderInsertDTO;
    }

}
