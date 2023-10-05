package org.ekwateur;

import org.ekwateur.adapters.ClientFactoryAdapter;
import org.ekwateur.adapters.exceptions.NotEnoughArgsException;

public class MainApplication {

    public static void main(String[] args) {

        try {
            if (args.length == 0) throw new NotEnoughArgsException("""
                    Please provide all args in CSV format as follow :
                    For Individuals:   IND;<reference>;<civilité>;<nom>;<prénom>;<consommation gaz>;<consommation éléctricité>
                    For professionals: PRO;<reference>;<SIRET>;<réseau social>;<CA>;<consommation gaz>;<consommation éléctricité>
                    """);

            ClientFactoryAdapter
                    .computeInvoiceClient(args)
                    .print();

        } catch (Exception anyUncheckedException) {

            System.err.println(anyUncheckedException.getMessage());
            System.exit(-1);
        }
    }

}
