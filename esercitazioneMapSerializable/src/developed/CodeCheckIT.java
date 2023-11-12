package developed;

public class CodeCheckIT implements CodeChecker {
    public boolean check(String cod){

        if (cod.length() != 7)
            return false;

        if(cod.charAt(0) != 'I' && cod.charAt(1) != 'T')
            return false;

        for(int i = 2; i < 4; i++){
            if(Character.isDigit(cod.charAt(i)))
                return false;
        }

        for(int i = 4; i < 7; i++){
            if(Character.isAlphabetic(cod.charAt(i)))
                return false;
        }

        return true;
    }
}
