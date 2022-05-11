package controller;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Data
public class ValuesToSave{

    private String amountToChange;
    private String changeFrom;
    private String changeTo;
    private String changedValue;
}