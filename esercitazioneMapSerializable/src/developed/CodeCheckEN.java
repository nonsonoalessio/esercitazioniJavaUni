package developed;

public class CodeCheckEN implements CodeChecker {
    public boolean check(String cod){

        if(cod.length() != 6)
            return false;

        if(cod.charAt(0) != 'E' && cod.charAt(1) != 'N')
            return false;

        for(int i = 2; i < 4; i++){
            if(Character.isAlphabetic(cod.charAt(i)))
                return false;
        }

        for(int i = 4; i < 6; i++){
            if(Character.isDigit(cod.charAt(i)))
                return false;
        }

        return true;
    }
}
