import { ref } from "vue";

export enum AccountType {
  Admin = "Admin",
  Enseignant = "Enseignant",
  Ecole = "Ecole",
  Disconnected = "Disconnected",
}

const accountTypeSingleton = ref<AccountType>(AccountType.Disconnected);

export function UseAccount() {
  setAccountTypeValue();
  // TODO : check cookie
  return {
    type: accountTypeSingleton,
  };
}

function setAccountTypeValue() {
  switch (getCookie("accountType")) {
    case AccountType.Admin:
      accountTypeSingleton.value = AccountType.Admin;
      break;
    case AccountType.Enseignant:
      accountTypeSingleton.value = AccountType.Enseignant;
      break;
    case AccountType.Ecole:
      accountTypeSingleton.value = AccountType.Ecole;
      break;
    default:
      accountTypeSingleton.value = AccountType.Disconnected;
      break;
  }
}

function getCookie(value: string): string | undefined {
  return document.cookie
    .split("; ")
    .find((c) => c.startsWith(value.concat("=")))
    ?.split("=")[1];
}
