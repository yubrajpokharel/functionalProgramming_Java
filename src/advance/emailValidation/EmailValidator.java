package advance.emailValidation;

import basics.Function;

import java.util.regex.Pattern;

/**
 * Created by ypokhrel on 12/27/2017.
 */
public class EmailValidator {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    final static Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);

    static Function<String, Result> emailChecker = s ->
        s == null
                ? new Result.Failure("Email cannot be null")
                : s.length() == 0
                    ? new Result.Failure("Email cannot be Empty")
                    : emailPattern.matcher(s).matches()
                        ? new Result.Success()
                        : new Result.Failure("Email is invalid : "+ s);


    static Executable validate(String email){
        Result result = emailChecker.apply(email);
        return result instanceof Result.Success
                ? () -> sendVerification(email)
                : () -> logError(((Result.Failure) result).getMessage());
    }

    static void sendVerification(String s){
        System.out.println("Email verified and send to : " + s);
    }

    private static void logError(String s){
        System.out.println("Error Message logged : " + s);
    }

    public static void main(String[] args) {
        validate("yubrajgmail.com").exec();
        validate(null).exec();
    }
}
