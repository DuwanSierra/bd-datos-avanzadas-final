export class GenericConstants {
  public static REGEX_TEXT_LATAM =
    '^[a-zA-Z0-9_\\-\\. áéíóúÁÉÍÓÚñÑäëïÖüÄËÏÖü]+$';
  public static MAX_LENGTH_NAME = 70;
  public static MIN_LENGTH_NAME = 3;
  public static REGEX_ADDRESS_LATAM =
    '^[a-zA-Z0-9_\\-\\. áéíóúÁÉÍÓÚñÑäëïÖüÄËÏÖü#]+$';
  public static REGEX_PHONE_NUMBER =
    '^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$';
  public static MAX_LENGTH_PHONE = 18;
  public static MIN_LENGTH_PHONE = 10;
}
