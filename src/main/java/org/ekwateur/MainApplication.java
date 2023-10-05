package org.ekwateur;

import org.ekwateur.adapters.ClientFactoryAdapter;
import org.ekwateur.adapters.ClientType;
import org.ekwateur.adapters.exceptions.NotEnoughArgsException;
import org.ekwateur.core.ClientInvoice;

public class MainApplication {

    //PRO;EKW12345678;SIRET001;SOCIAL0001;10000000;10;10
    //IND;EKW12345678;Mr;Jon;Doe;10;10
    public static void main(String[] args) {
        ClientInvoice client;

        if (args.length == 0) throw new NotEnoughArgsException("""
                Please provide all args in CSV format as follow :
                For Individuals:   IND;<reference>;<civilité>;<nom>;<prénom>;<consommation gaz>;<consommation éléctricité>
                For professionals: PRO;<reference>;<SIRET>;<réseau social>;<CA>;<consommation gaz>;<consommation éléctricité>
                """);

        ClientType clientType = ClientType.buildType(args[0]);
        if (clientType.equals(ClientType.PRO)) {
            client = ClientFactoryAdapter.buildPro(args);
        }
        if (clientType.equals(ClientType.IND)) {
            client = ClientFactoryAdapter.buildIndividual(args);
        }
    }
}
