import { useRouter } from 'next/router'

const Post = () => {
    const router = useRouter();
    const { pid, comment } = router.query;

    return <p>Post : {pid}, {comment}</p>
}

export default Post;