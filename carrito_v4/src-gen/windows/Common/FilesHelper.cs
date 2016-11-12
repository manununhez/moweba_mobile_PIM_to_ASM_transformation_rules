/* 
    Copyright (c) 2012 - 2013 Microsoft Corporation.  All rights reserved.
    Use of this sample source code is subject to the terms of the Microsoft license 
    agreement under which you licensed this sample source code and is provided AS-IS.
    If you did not accept the terms of the license agreement, you are not authorized 
    to use this sample source code.  For the terms of the license, please see the 
    license agreement between you and Microsoft.
  
    To see all Code Samples for Windows Phone, visit http://code.msdn.microsoft.com/wpapps
  
*/

//Start of user code imports
using System;
using System.Diagnostics;
using System.Threading.Tasks;
using Windows.Storage;
using Windows.Storage.Streams;
//End of user code
	
namespace CarritoDeCompras.Common
{
    class FilesHelper
    {
     
         class FilesHelper
    {
        private static StringBuilder folderContents;

        private const string FOLDER_PREFIX = "\\";
        private const int PADDING_FACTOR = 3;
        private const char SPACE = ' ';

        //Creating new folders and files
        public static async Task createFolder(string folderName)
        {
            StorageFolder localFolder = ApplicationData.Current.LocalFolder;
            StorageFolder newFolder = await localFolder.CreateFolderAsync(folderName, CreationCollisionOption.ReplaceExisting);
        }

        //create a new file in the local folder
        public static async Task createFile(string newFileName)
        {
            StorageFolder localFolder = ApplicationData.Current.LocalFolder;
            StorageFile newFile = await localFolder.CreateFileAsync(newFileName, CreationCollisionOption.ReplaceExisting);
        }

        // Save a photo to the app's local folder.
        public static async Task<string> SavePhoto(Stream photoToSave, string fileName)
        {
            StorageFolder localFolder = ApplicationData.Current.LocalFolder;
            StorageFile photoFile = await localFolder.CreateFileAsync(fileName, CreationCollisionOption.ReplaceExisting);
            using (var photoOutputStream = await photoFile.OpenStreamForWriteAsync())
            {
                await photoToSave.CopyToAsync(photoOutputStream);
            }

            return photoFile.Path;
        }

        // Write a text file to the app's local folder. 
        public static async Task<string> WriteTextFile(string filename, string contents)
        {
            StorageFolder localFolder = ApplicationData.Current.LocalFolder;
            StorageFile textFile = await localFolder.CreateFileAsync(filename, CreationCollisionOption.ReplaceExisting);
            using (IRandomAccessStream textStream = await textFile.OpenAsync(FileAccessMode.ReadWrite))
            {
                using (DataWriter textWriter = new DataWriter(textStream))
                {
                    textWriter.WriteString(contents);
                    await textWriter.StoreAsync();
                }
            }
            return textFile.Path;

        }

        // Read the contents of a text file from the app's local folder. 
        public static async Task<string> ReadTextFile(string filename)
        {
            string contents;
            StorageFolder localFolder = ApplicationData.Current.LocalFolder;
            StorageFile textFile = await localFolder.GetFileAsync(filename);
            using (IRandomAccessStream textStream = await textFile.OpenReadAsync())
            {
                using (DataReader textReader = new DataReader(textStream))
                {
                    uint textLength = (uint)textStream.Size;
                    await textReader.LoadAsync(textLength);
                    contents = textReader.ReadString(textLength);
                }
            }
            return contents;
        }


        // Begin recursive enumeration of files and folders.
        public static async Task<string> EnumerateFilesAndFolders(StorageFolder rootFolder)
        {
            // Initialize StringBuilder to contain output.
            folderContents = new StringBuilder();
            folderContents.AppendLine(FOLDER_PREFIX + rootFolder.Name);

            await ListFilesInFolder(rootFolder, 1);

            return folderContents.ToString();
        }

        // Continue recursive enumeration of files and folders.
        private static async Task ListFilesInFolder(StorageFolder folder, int indentationLevel)
        {
            string indentationPadding = String.Empty.PadRight(indentationLevel * PADDING_FACTOR, SPACE);

            // Get the subfolders in the current folder.
            // Increase the indentation level of the output.
            // For each subfolder, call this method again recursively.
            var foldersInFolder = await folder.GetFoldersAsync();
            int childIndentationLevel = indentationLevel + 1;
            foreach (StorageFolder currentChildFolder in foldersInFolder)
            {
                folderContents.AppendLine(indentationPadding + FOLDER_PREFIX + currentChildFolder.Name);
                await ListFilesInFolder(currentChildFolder, childIndentationLevel);
            }

            // Get the files in the current folder.
            var filesInFolder = await folder.GetFilesAsync();
            foreach (StorageFile currentFile in filesInFolder)
            {
                folderContents.AppendLine(indentationPadding + currentFile.Name);
            }
        }

   
    }
    
}

