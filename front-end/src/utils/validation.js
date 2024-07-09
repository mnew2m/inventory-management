export const checkNil = (value) => {
    return value === null || value === undefined;
};

export const checkEmptyString = (value) => {
    return checkNil(value) || value === '';
}
