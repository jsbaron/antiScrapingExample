import React from 'react';
import {Pagination} from "react-bootstrap";
import {useDispatch, useSelector} from "react-redux";
import {setPage} from "../redux/actions";

const MAX_PAGES = 205;

const PageNav = () => {
    const page = useSelector(state => state.page.page);

    const dispatch = useDispatch();

    const getNumPagesBefore = () => {
        if (page < 6) {
            return page - 1
        }
        return 5;
    }

    const getNumPagesAfter = () => {
        if (page > 200) {
            return MAX_PAGES - page
        }
        return 5;
    }

    const getPageNum = i => {
        if (page >= 6) {
            return page + ((i + 1) - 6);
        }
        return page + ((i+1) - page)
    }

    return (
        <div className={"d-flex"}>
            <Pagination className={"mx-auto"}>
                <Pagination.First
                    onClick={() => dispatch(setPage(1))}
                />
                <Pagination.Prev
                    disabled={page === 1}
                    onClick={() => dispatch(setPage(page - 1))}
                />
                {
                    Array(getNumPagesBefore()).fill(0).map(
                        (e, i) => <Pagination.Item
                            key={i}
                            onClick={() => dispatch(setPage(getPageNum(i)))}
                        >
                            {
                                getPageNum(i)
                            }
                        </Pagination.Item>
                    )
                }
                <Pagination.Item active>{page}</Pagination.Item>
                {
                    Array(getNumPagesAfter()).fill(0).map(
                        (e, i) => <Pagination.Item
                            key={i}
                            onClick={() => dispatch(setPage(page + i + 1))}
                        >
                            {page + i + 1}
                        </Pagination.Item>
                    )
                }
                <Pagination.Next
                    disabled={page === MAX_PAGES}
                    onClick={() => dispatch(setPage(page + 1))}
                />
                <Pagination.Last
                    onClick={() => dispatch(setPage(MAX_PAGES))}
                />
            </Pagination>
        </div>
    )
};

export default PageNav;