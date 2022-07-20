export class CustomConfirmDialogDto{
    public title?: string;
    public message?: string;
    public icon?: string;
    public cancelevent?: Function;
    public rejectEvent?: Function;
    public acceptEvent?: Function;
}