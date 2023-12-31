# Cypherithm
[![Version](https://img.shields.io/badge/version-1.0.1-green.svg)](https://shields.io/)
[![Open Source Love svg1](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/)
## Overview
Cypherithm is an Android library that provides encryption and decryption functionality for securing data in your Android applications. It simplifies the process of encrypting and decrypting data using popular encryption algorithms.

## Features
- Advanced Encryption Standard (AES): Encrypt and decrypt data using the AES algorithm, a widely adopted and secure encryption standard.
- Blowfish: Encrypt and decrypt data using the Blowfish algorithm, known for its simplicity and speed.

## Installation
### Step 1: Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
	repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
```

### Step 2: Add the dependency

```gradle
dependencies {
	        implementation 'com.github.adityasimant:Cypherithm:1.0.1'
	}
	
```
## Usage
### AES Encryption and Decryption
```java
// Encrypt & Decrypt using AES
String encryptedText = AESUtils.encrypt(context,"Hello, world!", "yourSecretKey");
String decryptedText = AESUtils.decrypt(context,encryptedText, "yourSecretKey");

```
### BlowFish Encryption and Decryption
```java
// Encrypt & Decrypt using Blowfish
String encryptedText = BlowfishUtils.encrypt(context,"Hello, world!", "yourPassword");
String decryptedText = BlowfishUtils.decrypt(context,encryptedText, "yourPassword");

```
### TripleDES Encryption and Decryption
```java
// Encrypt & Decrypt using TripleDES
String encryptedText = TripleDESUtils.encrypt(context,"Hello, world!", key);
String decryptedText = TripleDESUtils.decrypt(context,encryptedText, key);

```
You can download out [demo apk here](https://github.com/adityasimant/Cypherithm/releases/download/1.0.1/cypherithm.apk)
## Credits & Contact
Cypherithm is developed and maintained by [Aditya Simant](https://github.com/adityasimant).
For any inquiries or further information, please contact adityasimant88@gmail.com.




