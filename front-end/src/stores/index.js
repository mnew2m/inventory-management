import {defineStore} from "pinia";
import {computed, ref} from "vue";

export const useInventoryStore = defineStore('inventory', () => {
    const count = ref(0);
    const purchaseGridHeaders = ref([
        { title: '구매처', align: 'start', key: 'purchasePlace' },
        { title: '이미지', align: 'start', key: 'purchaseImage' },
        { title: '카테고리', align: 'start', key: 'category' },
        { title: '상품명', align: 'start', key: 'productName' },
        { title: '메모', align: 'start', key: 'productMemo' },
        { title: '가격', align: 'start', key: 'productPrice' },
        { title: '수량', align: 'start', key: 'productQty' },
        { title: '구매일', align: 'start', key: 'purchaseDate' },
    ]);
    const replacementCyclesGridHeaders = ref([
        { title: '카테고리', align: 'start', key: 'category' },
        { title: '상품명', align: 'start', key: 'productName' },
        { title: '메모', align: 'start', key: 'productMemo' },
        { title: '수량', align: 'start', key: 'productQty' },
        { title: '교체주기', align: 'start', key: 'cycles' },
        { title: '마지막교체일', align: 'start', key: 'replacementDate' },
    ]);
    const gridItems = ref([
        {
            purchaseId: 1,
            purchasePlace: '쿠팡',
            purchaseImage: '이미지 url1',
            category: '생활용품',
            productName: '휴대폰충전기',
            productMemo: '1미터짜리로 삼',
            productPrice: 45000,
            productQty: 1,
            purchaseDate: '20240702',
            cyclesYn: 'Y',
            cycles: 3,
        },
        {
            purchaseId: 2,
            purchasePlace: '11번가',
            purchaseImage: '이미지 url2',
            category: '생활용품',
            productName: '로지텍마우스',
            productMemo: 'G304',
            productPrice: 50000,
            productQty: 1,
            purchaseDate: '20240704',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 3,
            purchasePlace: '옥션',
            purchaseImage: '이미지 url3',
            category: '전자제품',
            productName: '헤드폰',
            productMemo: '노이즈캔슬링 기능',
            productPrice: 100000,
            productQty: 1,
            purchaseDate: '20240705',
            cyclesYn: 'Y',
            cycles: 8,
        },
        {
            purchaseId: 4,
            purchasePlace: 'G마켓',
            purchaseImage: '이미지 url4',
            category: '생활용품',
            productName: '물티슈',
            productMemo: '대용량 100매',
            productPrice: 20000,
            productQty: 2,
            purchaseDate: '20240706',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 5,
            purchasePlace: '네이버쇼핑',
            purchaseImage: '이미지 url5',
            category: '패션',
            productName: '운동화',
            productMemo: '사이즈 270',
            productPrice: 80000,
            productQty: 1,
            purchaseDate: '20240707',
            cyclesYn: 'Y',
            cycles: 6,
        },
        {
            purchaseId: 6,
            purchasePlace: '위메프',
            purchaseImage: '이미지 url6',
            category: '식품',
            productName: '아몬드',
            productMemo: '1kg',
            productPrice: 15000,
            productQty: 1,
            purchaseDate: '20240708',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 7,
            purchasePlace: '티몬',
            purchaseImage: '이미지 url7',
            category: '전자제품',
            productName: '키보드',
            productMemo: '기계식 키보드',
            productPrice: 70000,
            productQty: 1,
            purchaseDate: '20240709',
            cyclesYn: 'Y',
            cycles: 4,
        },
        {
            purchaseId: 8,
            purchasePlace: '인터파크',
            purchaseImage: '이미지 url8',
            category: '서적',
            productName: '자기계발서',
            productMemo: '베스트셀러',
            productPrice: 12000,
            productQty: 1,
            purchaseDate: '20240710',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 9,
            purchasePlace: '롯데홈쇼핑',
            purchaseImage: '이미지 url9',
            category: '생활용품',
            productName: '청소기',
            productMemo: '무선청소기',
            productPrice: 200000,
            productQty: 1,
            purchaseDate: '20240711',
            cyclesYn: 'Y',
            cycles: 12,
        },
        {
            purchaseId: 10,
            purchasePlace: '현대백화점',
            purchaseImage: '이미지 url10',
            category: '가구',
            productName: '의자',
            productMemo: '인체공학적 디자인',
            productPrice: 150000,
            productQty: 1,
            purchaseDate: '20240712',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 11,
            purchasePlace: '쿠팡',
            purchaseImage: '이미지 url11',
            category: '전자제품',
            productName: '태블릿',
            productMemo: '최신형',
            productPrice: 300000,
            productQty: 1,
            purchaseDate: '20240713',
            cyclesYn: 'Y',
            cycles: 9,
        },
        {
            purchaseId: 12,
            purchasePlace: '11번가',
            purchaseImage: '이미지 url12',
            category: '생활용품',
            productName: '비누',
            productMemo: '천연 비누',
            productPrice: 5000,
            productQty: 5,
            purchaseDate: '20240714',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 13,
            purchasePlace: '옥션',
            purchaseImage: '이미지 url13',
            category: '식품',
            productName: '과자 세트',
            productMemo: '여러 종류',
            productPrice: 25000,
            productQty: 1,
            purchaseDate: '20240715',
            cyclesYn: 'Y',
            cycles: 2,
        },
        {
            purchaseId: 14,
            purchasePlace: 'G마켓',
            purchaseImage: '이미지 url14',
            category: '전자제품',
            productName: '모니터',
            productMemo: '4K 해상도',
            productPrice: 400000,
            productQty: 1,
            purchaseDate: '20240716',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 15,
            purchasePlace: '네이버쇼핑',
            purchaseImage: '이미지 url15',
            category: '패션',
            productName: '청바지',
            productMemo: '사이즈 32',
            productPrice: 60000,
            productQty: 1,
            purchaseDate: '20240717',
            cyclesYn: 'Y',
            cycles: 7,
        },
        {
            purchaseId: 16,
            purchasePlace: '위메프',
            purchaseImage: '이미지 url16',
            category: '생활용품',
            productName: '샴푸',
            productMemo: '500ml',
            productPrice: 12000,
            productQty: 1,
            purchaseDate: '20240718',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 17,
            purchasePlace: '티몬',
            purchaseImage: '이미지 url17',
            category: '서적',
            productName: '소설책',
            productMemo: '베스트셀러',
            productPrice: 15000,
            productQty: 1,
            purchaseDate: '20240719',
            cyclesYn: 'Y',
            cycles: 5,
        },
        {
            purchaseId: 18,
            purchasePlace: '인터파크',
            purchaseImage: '이미지 url18',
            category: '식품',
            productName: '커피',
            productMemo: '원두 1kg',
            productPrice: 20000,
            productQty: 1,
            purchaseDate: '20240720',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 19,
            purchasePlace: '롯데홈쇼핑',
            purchaseImage: '이미지 url19',
            category: '가구',
            productName: '책상',
            productMemo: '사무용',
            productPrice: 100000,
            productQty: 1,
            purchaseDate: '20240721',
            cyclesYn: 'Y',
            cycles: 4,
        },
        {
            purchaseId: 20,
            purchasePlace: '현대백화점',
            purchaseImage: '이미지 url20',
            category: '전자제품',
            productName: '스마트워치',
            productMemo: '피트니스 기능',
            productPrice: 250000,
            productQty: 1,
            purchaseDate: '20240722',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 21,
            purchasePlace: '쿠팡',
            purchaseImage: '이미지 url21',
            category: '생활용품',
            productName: '텀블러',
            productMemo: '보온/보냉 기능',
            productPrice: 30000,
            productQty: 1,
            purchaseDate: '20240723',
            cyclesYn: 'Y',
            cycles: 3,
        },
        {
            purchaseId: 22,
            purchasePlace: '11번가',
            purchaseImage: '이미지 url22',
            category: '패션',
            productName: '자켓',
            productMemo: '봄/가을용',
            productPrice: 90000,
            productQty: 1,
            purchaseDate: '20240724',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 23,
            purchasePlace: '옥션',
            purchaseImage: '이미지 url23',
            category: '식품',
            productName: '과일 세트',
            productMemo: '혼합과일',
            productPrice: 35000,
            productQty: 1,
            purchaseDate: '20240725',
            cyclesYn: 'Y',
            cycles: 6,
        },
        {
            purchaseId: 24,
            purchasePlace: 'G마켓',
            purchaseImage: '이미지 url24',
            category: '서적',
            productName: '만화책',
            productMemo: '전집',
            productPrice: 100000,
            productQty: 1,
            purchaseDate: '20240726',
            cyclesYn: 'N',
            cycles: 0,
        },
        {
            purchaseId: 25,
            purchasePlace: '네이버쇼핑',
            purchaseImage: '이미지 url25',
            category: '전자제품',
            productName: '태블릿 케이스',
            productMemo: '충격 방지',
            productPrice: 15000,
            productQty: 1,
            purchaseDate: '20240727',
            cyclesYn: 'Y',
            cycles: 2,
        },
    ]);
    // const getPurchaseGridItems = computed(() => gridItems.value.filter(x => x.cyclesYn === 'Y'));
    const getReplacementGridItems = computed(() => gridItems.value.filter(x => x.cyclesYn === 'Y'));

    function deleteGridItem(items) {
        for(let i in items){
            const index = gridItems.value.indexOf(items[i]);
            gridItems.value.splice(index, 1);
        }
    }
    function increment() {
        count.value++
    }

    return {
        count, purchaseGridHeaders, replacementCyclesGridHeaders,
        gridItems, getReplacementGridItems,
        deleteGridItem, increment
    }
})