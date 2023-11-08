import { onMounted, ref } from "vue";

export enum AccountType {
  Admin = "Admin",
  Enseignant = "Enseignant",
  Ecole = "Ecole",
  Disconnected = "Disconnected",
}

const accountTypeSingleton = ref<AccountType>(AccountType.Disconnected);
const accountIdSingleton = ref<number>(0);

export function UseAccount() {
  onMounted(() => {
    setAccountTypeValue();
    setAccountId();
  });
  // TODO : check cookie
  return {
    type: accountTypeSingleton,
    id: accountIdSingleton,
  };
}

function setAccountTypeValue() {
  const accountType = getCookie("userType");
  switch (accountType) {
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
      console.warn("Unknown account type", accountType);
      accountTypeSingleton.value = AccountType.Disconnected;
      break;
  }
}
function setAccountId() {
  const id = Number(getCookie("userId"));
  if (Number.isInteger(id)) {
    accountIdSingleton.value = id;
  }
}

function getCookie(value: string): string | undefined {
  return document.cookie
    .split("; ")
    .find((c) => c.startsWith(value.concat("=")))
    ?.split("=")[1];
}
