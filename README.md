# JavaRush-cryptoanalyser
Encryption/decryption by Cesare method console application

CryptoCode
Short Description
Console application for encryption and decryption of the text by the key using Cesare method.

Limitations
It should be inserted the full pass to source and destination file. The Key of encryption/decryption 
(here as to Key) is limited by the length of constant ALPHABET – 41.

Description of algorithm
The encryption/decryption is made by comparing the letters from source file to the letters from ALPHABET 
by means of loop, the index of encrypted letter is found by adding of the Key to index of ALPHABET letter.

Class description
In root package of the project there are three classes;
Main (the entrance point is here)
DialogueUser (class accept all String parameters for dialogue with User)
FileOperations (class includes two methods which read and write files accordingly)
CryptoOperations (class includes two methods which encrypt and decrypt text accordingly)

General information
1. The dialogue with User is made by means of console.
2. The example of source and root files accordingly:
      c:\\folderName\\fileName.txt
3. In case if the file doesn't exist, the User will see the following massage:
      "Hello, User, please, insert the path to source file:
      d:\\SomeFolder\\input1txt
      It is not the path to the file. Please insert the pass to the file:"
4. In case if the User type the Key beyond the limits from 1 to the length of ALPHABET, 
the User will be asked for Key again.
5. In case if the User type the options of Encryption/Decryption beyond 1 or 2, the User will 
be asked for to choose the Option again.
6. The result of the program is the pass to the destination file with encrypted/decrypted text. 