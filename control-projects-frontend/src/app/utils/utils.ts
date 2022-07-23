export class Utils {
  public static generateUUID() {
    // Public Domain/MIT
    var d = new Date().getTime(); //Timestamp
    var d2 =
      (typeof performance !== 'undefined' &&
        performance.now &&
        performance.now() * 1000) ||
      0; //Time in microseconds since page-load or 0 if unsupported
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(
      /[xy]/g,
      function (c) {
        var r = Math.random() * 16; //random number between 0 and 16
        if (d > 0) {
          //Use timestamp until depleted
          r = (d + r) % 16 | 0;
          d = Math.floor(d / 16);
        } else {
          //Use microseconds since page-load if supported
          r = (d2 + r) % 16 | 0;
          d2 = Math.floor(d2 / 16);
        }
        return (c === 'x' ? r : (r & 0x3) | 0x8).toString(16);
      }
    );
  }

  public static getErrorControl(errorsCode: string[]): string {
    let errorMessage = '';
    errorsCode.forEach((error) => {
      switch (error) {
        case 'required':
          errorMessage += 'Este campo es requerido,';
          break;
        case 'pattern':
          errorMessage +=
            'La información que tratas de ingresar no cumple con el patrón,';
          break;
        case 'minlength':
        case 'maxlength':
          errorMessage +=
            'La información que tratas de ingresar no tiene la longitud válida,';
          break;
        default:
          errorMessage += 'Debes ingresar información válida en el campo,';
          break;
      }
    });
    return errorMessage.substring(0, errorMessage.length - 1);
  }
}
