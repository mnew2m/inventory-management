export const formatDate = (dateString, defaultValue = '', dateFormat = 'yyyy-MM-dd') => {
    if (dateString.length !== 8) return defaultValue;
    return `${dateString.substring(0, 4)}-${dateString.substring(4, 6)}-${dateString.substring(6, 8)}`;
};

export const addComma = (value) => {
    return value.toLocaleString();
}