# Sharing App

An Android application designed to help users track items they own and manage sharing them with contacts. The app keeps a local record of your inventory and logs which items are currently available versus those borrowed by your contacts.

## Features
* **Item Management:** Add, edit, and delete items. Items can include a title, maker, description, dimensions, and a photo.
* **Contact Management:** Maintain a list of contacts with their usernames and emails. Active borrowers cannot be deleted while they possess an item.
* **Status Tracking:** Mark items as 'Available' or 'Borrowed'. Assign specific contacts from your list to borrowed items.
* **Tabbed Interface:** Quickly navigate between 'All Items', 'Available', and 'Borrowed' using a swipeable tab layout powered by fragments.
* **Local Persistence:** Data is reliably saved and loaded locally on the device using JSON serialization.

## UML Diagram

[View the Sharing App UML Diagram here](images/_378261654f7e71fc7355bb8aa5d67853_UML-Class-Diagram-Contacts.png)

## Demo Video

[![Demo Video](https://img.youtube.com/vi/oIUsJU0c_wg/0.jpg)](https://youtu.be/oIUsJU0c_wg?si=3hk0Eoq06Jiqw_TX)

## Tech Stack
* **Language:** Java
* **Platform:** Android SDK
* **Data Storage:** [Google Gson](https://github.com/google/gson) for object serialization/deserialization into `.sav` local files.
* **UI Components:** `ViewPager`, `TabLayout`, `FragmentPagerAdapter`, and custom `ArrayAdapter` implementations.

## Getting Started

### Prerequisites
* Android Studio installed on your local machine.
* Minimum SDK requirements as defined in the `build.gradle` file.

## Application Structure
* **Activities:** `MainActivity` acts as the host for the tabbed item interface. Dedicated activities handle form submissions (`AddItemActivity`, `AddContactActivity`, `EditItemActivity`, `EditContactActivity`).
* **Fragments:** `AllItemsFragment`, `AvailableItemsFragment`, and `BorrowedItemsFragment` cleanly separate the data views based on item status.
* **Models:** `Item`, `Contact`, `ItemList`, `ContactList`, and `Dimensions` represent the domain entities.
