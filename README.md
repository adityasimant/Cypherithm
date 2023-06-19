# Cypherithm
[![Version](https://img.shields.io/badge/version-1.0.0-green.svg)](https://shields.io/)
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
	        implementation 'com.github.adityasimant:Cypherithm:1.0.0'
	}
	
```
## Usage
### AES Encryption and Decryption
```java
/ Encrypt using AES
String encryptedText = AESUtils.encrypt("Hello, world!", "yourSecretKey");

// Decrypt using AES
String decryptedText = AESUtils.decrypt(encryptedText, "yourSecretKey");

```
### BlowFish Encryption and Decryption
```java
// Encrypt using Blowfish
String encryptedText = BlowfishUtils.encrypt("Hello, world!", "yourPassword");

// Decrypt using Blowfish
String decryptedText = BlowfishUtils.decrypt(encryptedText, "yourPassword");

```
## Credits & Contact
Your Library Name is developed and maintained by [Aditya Simant](https://github.com/adityasimant).
For any inquiries or further information, please contact adityasimant88@gmail.com.




