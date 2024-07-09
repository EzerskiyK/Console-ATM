package services;

import entities.Atm;
import entities.BankCard;
import entities.SavedDataFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class SavedDataFromFileService {

    private final SavedDataFromFile savedDataFromFile;

    public SavedDataFromFileService(SavedDataFromFile savedDataFromFile) {
        this.savedDataFromFile = savedDataFromFile;
    }



    public void enrichFromFile() {
        Map<String, String> dataFromFile = dataFromFile();

        savedDataFromFile.setCardNumber(dataFromFile.get("cardNumber"));
        savedDataFromFile.setCardPin(Integer.parseInt(dataFromFile.get("cardPin")));
        savedDataFromFile.setCardBalance(Integer.parseInt(dataFromFile.get("cardBalance")));
        savedDataFromFile.setCardUnblockDate(new Date(Long.parseLong(dataFromFile().get("cardUnblockDate"))));
        savedDataFromFile.setAtmAmountOfMoney(Integer.parseInt(dataFromFile.get("atmAmountOfMoney")));
        savedDataFromFile.setAtmWithdrawalLimit(Integer.parseInt(dataFromFile.get("atmWithdrawalLimit")));

    }

    public void saveToFile(){

        File file = new File("SavedDataFile");
        try(PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(savedDataFromFile.getCardNumber() + " " +
                    savedDataFromFile.getCardPin() + " " +
                    savedDataFromFile.getCardBalance() + " " +
                    savedDataFromFile.getCardUnblockDate().getTime() + " " +
                    savedDataFromFile.getAtmAmountOfMoney() + " " +
                    savedDataFromFile.getAtmWithdrawalLimit());
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Atm initializationAtmFromFileData() {
        return new Atm(savedDataFromFile.getAtmAmountOfMoney(),
                savedDataFromFile.getAtmWithdrawalLimit());
    }

    public BankCard initializationBankCardFromFileData(){
        return new BankCard(savedDataFromFile.getCardNumber(),
                savedDataFromFile.getCardPin(),
                savedDataFromFile.getCardBalance(),
                savedDataFromFile.getCardUnblockDate());
    }

    private Map<String, String> dataFromFile(){
        File file = new File("SavedDataFile");
        try(Scanner scanner = new Scanner(file)) {

            List<String> dataList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

            Map<String, String> dataMap = new HashMap<>();

            dataMap.put("cardNumber", dataList.get(0));
            dataMap.put("cardPin", dataList.get(1));
            dataMap.put("cardBalance", dataList.get(2));
            dataMap.put("cardUnblockDate", dataList.get(3));
            dataMap.put("atmAmountOfMoney", dataList.get(4));
            dataMap.put("atmWithdrawalLimit", dataList.get(5));

            return dataMap;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
