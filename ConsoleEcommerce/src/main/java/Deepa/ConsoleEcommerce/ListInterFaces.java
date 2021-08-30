package Deepa.ConsoleEcommerce;

import java.io.File;
import java.util.List;

public interface ListInterFaces {
		void AddUserItem( File uf,File it);
		void TempUserItemAll(File uf,File rec);
		void BinToCart(File uf,File delf);
		void TempUserItem(File uf,File delf);
		void AddAdminItem(File uf);
		void TempAdminUserItem(File ItemFile,File UserF,File BinFile,File ItemBinFile);
		void TempAdminUserItemAll(File ItemFile,File UserF,File BinFile,File ItemBinFile);
		void BinToCart(File ItemFile,File UserF,File BinFile,File ItemBinFile);
		void AddUpdateItem(File ItemFile,File UserF,File BinFile,File ItemBinFile);
}
