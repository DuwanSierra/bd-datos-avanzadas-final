export class CustomTableConfiguration {
  public headers?: CustomTableHeader[];
  public dataConfig?: CustomTableItem[];
  public showSelectCheck?: boolean = false;
  public showActions?: boolean = true;
}

export class CustomTableHeader {
  public label?: string;
}

export class CustomTableItem {
  public key?: string;
}
